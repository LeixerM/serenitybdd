pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clona el repositorio desde GitHub
                git url: 'https://github.com/LeixerM/serenitybdd.git', branch: 'main'
            }
        }

        stage('Build and Test') {
            steps {
                // Limpia y ejecuta las pruebas
                script {
                    if (fileExists('gradlew.bat')) {
                        bat 'gradlew.bat clean test aggregate'
                    } else {
                        bat 'gradle clean test aggregate'
                    }
                }
            }
        }

        stage('Publish Report') {
            steps {
                // Publica los reportes de Serenity
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: 'Serenity Report'
                ])
            }
        }
    }

    post {
        always {
            // Opcional: Archiva los artefactos de la construcción
            archiveArtifacts artifacts: 'target/site/serenity/**', allowEmptyArchive: true
        }
        failure {
            // Enviar una notificación en caso de fallo (puedes integrar con Slack, email, etc.)
            echo 'Build failed!'
        }
        success {
            echo 'Build succeeded!'
        }
    }
}
