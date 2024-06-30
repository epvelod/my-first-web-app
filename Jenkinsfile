pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat './gradlew.bat clean build'
            }
        }
        stage('Example') {
            steps {
                echo "Token: $PUBLISHING_TOKEN"
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                        docker.build('first-spring-demo:latest', '--build-arg PACKAGE_TOKEN=$PUBLISHING_TOKEN')
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
