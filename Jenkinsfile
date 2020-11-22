pipeline {
    agent any

    stages {
        stage('Pull sources') {
            steps {
                echo 'Pulling scm..'
				git branch: 'demo_bbl',
					credentialsId: 'github_gerwais',
					url: 'https://github.com/gerwaismomo/tictactoe.git'

				sh "ls -lat"
            }
        }
        stage('Compile') {
            steps {
                echo 'Building..'
				sh "mvn clean validate compile"

            sh "ls -lat"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
				sh "mvn clean test"
            }
        }
        stage('Code quality') {
            steps {
                echo 'Testing..'
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