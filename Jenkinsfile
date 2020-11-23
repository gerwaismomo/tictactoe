pipeline {
    agent any

    stages {
        stage('Pull sources') {
            steps {
                echo 'Pulling scm..'
				git branch: 'demo_bbl',
					credentialsId: 'github_gerwais',
					url: 'https://github.com/gerwaismomo/tictactoe.git'

				withMaven (maven: 'maven-tool')  {
					sh "mvn clean validate"
				}
            }
        }
        stage('Compile') {
            steps {
                echo 'Compiling..'
				
				withMaven (maven: 'maven-tool') {
					sh "mvn clean validate compile"
				}
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
				withMaven (maven: 'maven-tool') {
					sh "mvn test"
				}
            }
        }
        stage('Code quality') {
            steps {
                echo 'Push to SonarQube..'
				
				withMaven (maven: 'maven-tool') {
					sh "mvn sonar:sonar \
							-Dsonar.projectKey=bbl.gerwais.youssef \
							-Dsonar.projectName=DemoBBL \
							-Dsonar.projectVersion=bbl.24.11.2020 \
							-Dsonar.host.url=http://147.75.101.5:9000 \
							-Dsonar.login=1307b18f7c82907d5987cad1eea41ca45d10511b"
				}
            }
        }
        stage('Release') {
            steps {
                echo 'Releasing....'
            }
        }
        stage('Notify') {
            steps {
                echo 'Mailing....'
            }
        }
    }
}