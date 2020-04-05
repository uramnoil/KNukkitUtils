import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.71"
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "5.2.0"
    id("org.jetbrains.dokka") version "0.10.1"
    id("com.jfrog.bintray") version ("1.8.4")
}

group = "com.uramnoil"
version = "0.1.3"

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
    from(sourceSets.getByName("main").allSource)
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
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = "kotlib"
            from(components["kotlin"])
            artifact(sourcesJar)
            artifact(dokkaJar)
            pom {
                name.set("UramnOIL")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("http://www.opensource.org/licenses/mit-license.php")
                        distribution.set("repo")
                    }
                }
                developers {
                    developer {
                        name.set("UramnOIL")
                        email.set("uramnoil@outlook.jp")
                    }
                }
                scm {
                    url.set("https://github.com/UramnOIL/Kotlib")
                }
            }
        }
    }
}

bintray {
    user = project.findProperty("bintrayUser").toString()
    key = project.findProperty("bintrayApiKey").toString()

    publish = true

    setPublications("maven")

    with(pkg) {
        repo = "nukkit"
        name = "kotlib"
        userOrg = user
        publicDownloadNumbers = true
        setLicenses("MIT")
        vcsUrl = "https://github.com/UramnOIL/Kotlib"
        with(version) {
            name = project.version.toString()
        }
    }
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))
}
repositories {
    mavenCentral()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}