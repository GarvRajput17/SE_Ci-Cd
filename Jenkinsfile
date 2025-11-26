pipeline {
    agent any

    environment {
        // Docker Hub credentials configured in Jenkins (Username/Password)
        DOCKER_CRED = credentials('dockerhub-creds')

        // Image name and tag similar to the demo Jenkinsfile
        IMAGE = "${DOCKER_CRED_USR}/ci-cd-todo:latest"
    }

    stages {

        stage('Checkout') {
            steps {
                // Use the same repo/branch this Jenkinsfile comes from
                checkout scm
            }
        }

        stage('Build') {
            steps {
                withMaven(maven: 'maven3') {
                    sh 'mvn -B clean package'
                }
            }
        }
        
        stage('Run Tests') {
            steps {
                withMaven(maven: 'maven3') {
                    sh 'mvn -B test'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${IMAGE} ."
                sh "docker images | grep ${IMAGE}"
            }
        }

        stage('Push Docker Image') {
            steps {
                sh """
                    echo "${DOCKER_CRED_PSW}" | docker login -u "${DOCKER_CRED_USR}" --password-stdin
                    docker push ${IMAGE}
                """
            }
        }

        stage('Deploy Container') {
            steps {
                sh """
                    docker pull ${IMAGE}
                    docker stop ci-cd-todo || true
                    docker rm ci-cd-todo || true
                    docker run -d -p 8080:8080 --name ci-cd-todo ${IMAGE}
                """
            }
        }
    }
}
