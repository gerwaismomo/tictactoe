pipeline {
    agent any

    stages {
        stage('Pull sources') {
            steps {
                echo 'Pulling scm..'
				git branch: 'my_specific_branch',
					credentialsId: 'github_gerwais',
					url: 'https://github.com/gerwaismomo/tictactoe.git'

				sh "ls -lat"
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
				git branch: 'my_specific_branch',
                credentialsId: 'my_cred_id',
                url: 'ssh://git@test.com/proj/test_proj.git'

            sh "ls -lat"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
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