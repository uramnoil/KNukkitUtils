plugins {
    kotlin("jvm") version "1.3.61"
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "5.2.0"
    id("org.jetbrains.dokka") version "0.10.1"
}

group = "com.uramnoil"
version = "0.1.1"

tasks.dokka {
    outputFormat = "html"
    outputDirectory = "$buildDir/javadoc"
    configuration {
        skipDeprecated = false
        reportUndocumented = true
        skipEmptyPackages = true
        jdkVersion = 8
    }
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

val dokkaJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    archiveClassifier.set("javadoc")
    from(tasks.dokka)
    dependsOn(tasks.dokka)
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

publishing {
    val username = System.getenv("ARCHIVA_DEPLOY_USER_ID")
    val password = System.getenv("ARCHIVA_DEPLOY_USER_PW")

    repositories {
        maven(url = "https://maven.uramnoil.com/repository/releases") {
            credentials {
                this.username = username
                this.password = password
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = "knukkitutils"
            from(components["kotlin"])
            artifact(sourcesJar)
            artifact(dokkaJar)
        }
    }
}

repositories {
    jcenter()
    maven {
        url = uri("https://repo.nukkitx.com/main/")
    }
}

dependencies {
    compileOnly(kotlin("stdlib"))
    compileOnly("cn.nukkit", "nukkit", "1.0-SNAPSHOT")
}

