pipeline {
    agent any

    environment {
        DOCKER_CRED = credentials('garvrajput17')      // your Docker Hub credential ID
        IMAGE_NAME  = "${DOCKER_CRED_USR}/todo-cli"
        IMAGE_TAG   = "latest"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn -B clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn -B test'
            }
        }

        stage('Docker Build') {
            when {
                expression { currentBuild.resultIsBetterOrEqualTo('SUCCESS') }
            }
            steps {
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
                sh "docker images | grep ${IMAGE_NAME}"
            }
        }

        stage('Docker Push') {
            when {
                expression { currentBuild.resultIsBetterOrEqualTo('SUCCESS') }
            }
            steps {
                sh """
                    echo "${DOCKER_CRED_PSW}" | docker login -u "${DOCKER_CRED_USR}" --password-stdin
                    docker push ${IMAGE_NAME}:${IMAGE_TAG}
                """
            }
        }
    }

    post {
        always {
            sh 'docker logout || true'
        }
    }
}