pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat './gradlew.bat clean build'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build('first-spring-demo:latest')
                }
            }
        }
        stage('Example') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'publishing-token', passwordVariable: 'TOKEN', usernameVariable: 'USERNAME')]) {
                    // Aquí puedes usar las variables de entorno USERNAME y TOKEN
                    echo "Username: $USERNAME"
                    export PACKAGE_TOKEN=$TOKEN

                    echo "Token: $PACKAGE_TOKEN"
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
