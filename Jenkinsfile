pipeline {
  agent any
  stages {
    stage('sonar') {
      steps {
        waitForQualityGate true
      }
    }
  }
}