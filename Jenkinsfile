pipeline{
    agent {
        docker {image 'asuhail8/ecomm'}
    }
    environment {
      // moving the cache to the workspace might speed up
      // the build stage.  maybe use ${env.WORKSPACE}/.build_cache?
      //GOCACHE = "/tmp" - saves the build cache in temp folder which gets deleted
      GOCAHCE = "${env.WORKSPACE}/.build_cache"
    }
    stages{
        stage('Run regression tests'){
            steps{
                sh 'mvn test -Pregression'
            }
        }
       stage('Run error validation Tests'){
            steps{
                sh 'mvn test -PerrorHandling'
            }
            post{
                always{
                   archiveArtifacts artifacts: 'reports/index.html', followSymlinks: false 
                }
            }
        }
    }
}