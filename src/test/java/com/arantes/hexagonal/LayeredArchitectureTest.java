package com.arantes.hexagonal;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.boot.test.context.SpringBootTest;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.arantes.hexagonal")
@SpringBootTest
class LayeredArchitectureTest {


	/**
	 * Este teste verifica a arquitetura em camadas da aplicação.
	 * Ele garante que as dependências entre as camadas sigam as regras definidas.
	 * As camadas são:
	 * - AdaptersIn: Adaptadores de entrada (ex.: controladores REST)
	 * - AdaptersOut: Adaptadores de saída (ex.: repositórios)
	 * - UseCase: Casos de uso principais da aplicação
	 * - PortsIn: Portas de entrada (interfaces para casos de uso)
	 * - PortsOut: Portas de saída (interfaces para serviços externos)
	 * - Config: Classes de configuração
	 */
	@ArchTest
	public static final ArchRule layered_architecture_test = layeredArchitecture()
			.consideringAllDependencies()
			.layer("AdaptersIn").definedBy("..adapters.in..")
			.layer("AdaptersOut").definedBy("..adapters.out..")
			.layer("UseCase").definedBy("..application.core.usecase..")
			.layer("PortsIn").definedBy("..application.ports.in..")
			.layer("PortsOut").definedBy("..application.ports.out..")
			.layer("Config").definedBy("..config..")
			.whereLayer("AdaptersIn").mayOnlyBeAccessedByLayers("Config")
			.whereLayer("AdaptersOut").mayOnlyBeAccessedByLayers("Config")
			.whereLayer("UseCase").mayOnlyBeAccessedByLayers("Config")
			.whereLayer("PortsIn").mayOnlyBeAccessedByLayers("UseCase", "AdaptersIn")
			.whereLayer("PortsOut").mayOnlyBeAccessedByLayers("UseCase", "AdaptersOut")
			.whereLayer("Config").mayNotBeAccessedByAnyLayer();
}

