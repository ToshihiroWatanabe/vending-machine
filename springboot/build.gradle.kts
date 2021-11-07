import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.moowork.node") version "1.3.1"
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
}

group = "app"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.5.6")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.31")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0")
    implementation("org.springframework.boot:spring-boot-starter-security:2.5.6")
    implementation("io.springfox:springfox-swagger2:2.9.2")
    implementation("io.springfox:springfox-swagger-ui:2.9.2")
    developmentOnly("org.springframework.boot:spring-boot-devtools:2.5.6")
    runtimeOnly("mysql:mysql-connector-java:8.0.27")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("io.mockk:mockk:1.12.0")
    testImplementation("com.github.springtestdbunit:spring-test-dbunit:1.3.0")
    testImplementation("org.dbunit:dbunit:2.7.2")
    testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:2.2.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.6") {
        exclude(module = "junit")
        exclude(module = "junit-vintage-engine")
        exclude(module = "mockito-core")
    }
    testImplementation(platform("org.testcontainers:testcontainers-bom:1.16.2"))
    testImplementation("org.testcontainers:mysql:1.16.2")
    testImplementation("org.testcontainers:junit-jupiter:1.16.2")
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

task("copyDir") {
    copy {
        from("./../react/build")
        into("./build/resources/main/static")
    }
}

tasks.getByName("build").dependsOn("copyDir")