pluginManagement { repositories { google(); mavenCentral(); gradlePluginPortal() } }
dependencyResolutionManagement { repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS); repositories { google(); mavenCentral() } }
rootProject.name = "AndroidLab6Soldatov"
include(":activitylifecycle")
include(":artspace6")
include(":dessertclicker")
include(":unscramble")
