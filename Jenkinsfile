pipeline {
    agent any

    stages {
        stage('Build') {
           steps {
              sh 'javac src/Hello.java'
           }
       }

        stage('Test') {
           steps {
              sh 'java -cp src Hello'
           }
       }
    }
}
