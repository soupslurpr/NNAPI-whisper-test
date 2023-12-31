pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            name = "ossrh-snapshot"
            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        }
    }
}

rootProject.name = "NNAPI whisper test"
include(":app")
