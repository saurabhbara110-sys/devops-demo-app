pipeline {
    agent any

    stages {
        stage('Build Docker Image') {
           steps {
              sh 'docker build -t devops-demo-app:1.0 .'
           }
       }

        stage('Run Docker Container') {
           steps {
              sh 'docker run --rm devops-demo-app:1.0'
           }
       }
    }
}
