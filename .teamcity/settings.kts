import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.pipelines.*
import jetbrains.buildServer.configs.kotlin.triggers.vcs

version = "2025.11"

project {

    buildType(Build)

    pipeline(Pipeline1)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }
})


object Pipeline1 : Pipeline({
    name = "Pipeline1"

    repositories {
        repository(DslContext.settingsRoot)
    }

    triggers {
        vcs {
        }
    }
    val numJobs=150
    for (i in 1..numJobs) {
    job({
                    id("job" + "_$i")
                    name = "job $i"
    })
    }
})

object Pipeline1_Job1 : Job({
    id("Job1")
    name = "Job 1"
})

object Pipeline1_Job2 : Job({
    id("Job2")
    name = "Job 2"
})
