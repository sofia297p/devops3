pipeline {
    agent any
    
    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/sofia297p/devops1.git'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    def dockerImage = docker.build('my_image', '-f script.Dockerfile .')
                    dockerImage.push() 
                }
            }
        }
    }
}