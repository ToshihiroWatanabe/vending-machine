import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("com.moowork.node") version "1.3.1"
	kotlin("jvm") version "1.5.21"
	kotlin("plugin.spring") version "1.5.21"
}

group = "app"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web:2.5.4")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.5")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0")
	implementation("org.springframework.boot:spring-boot-starter-security:2.5.4")
	developmentOnly("org.springframework.boot:spring-boot-devtools:2.5.4")
	runtimeOnly("mysql:mysql-connector-java:8.0.25")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
	testImplementation("org.junit.jupiter:junit-jupiter:5.8.0")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
	testImplementation("io.mockk:mockk:1.12.0")
	testImplementation("com.github.springtestdbunit:spring-test-dbunit:1.3.0")
	testImplementation("org.dbunit:dbunit:2.7.2")
	testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:2.2.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.4") {
		exclude(module = "junit")
		exclude(module="junit-vintage-engine")
		exclude(module = "mockito-core")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

task("copyDir"){
		copy {
			from("./../react/build")
			into("./build/resources/main/static")
		}
}

tasks.getByName("build").dependsOn("copyDir")