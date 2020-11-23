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