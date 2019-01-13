pipeline {
  agent any
  stages {
    stage('echo') {
      steps {
        echo 'hi de amira'
      }
    }
    stage('error') {
      steps {
        waitForQualityGate true
      }
    }
  }
}