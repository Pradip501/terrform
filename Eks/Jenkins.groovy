pipeline {
    agent any
    stages {
        stage('Pull') {
            steps {
                git branch: 'main', url: 'https://github.com/Pradip501/terrform.git'
            }
        }   
        stage('Test') {
            steps {
                sh '''  cd Eks/
                        terraform init
                        terraform plan'''
            }
        }   
        stage('Deploy') {
            steps {
                sh ''' cd Eks/
                    terraform init
                    terraform apply --auto-approve'''
            }
        }
    }
}