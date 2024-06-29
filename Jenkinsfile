pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://your-repo-url.git'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build('your-docker-image:latest')
                }
            }
        }
//         stage('Deploy') {
//             steps {
//                 withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'dockerhub-credentials']) {
//                     sh 'docker push your-docker-image:latest'
//                 }
//                 sh 'az login --service-principal -u <client_id> -p <client_secret> --tenant <tenant_id>'
//                 sh 'az webapp config container set --resource-group <resource_group> --name <app_name> --docker-custom-image-name your-docker-image:latest'
//             }
//         }
    }

    post {
        always {
            archiveArtifacts artifacts: 'build/libs/*.jar', allowEmptyArchive: true
        }
    }
}
