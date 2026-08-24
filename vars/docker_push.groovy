def call(){
  sh 'docker build -t my_nihon_app .'
                withCredentials([
                    usernamePassword(
                        credentialsId: 'docker_hub_user_password',
                        usernameVariable: 'USERNAME',
                        passwordVariable: 'PASSWORD'
                    )
                ]) {
                    sh 'docker tag my_nihon_app "$USERNAME"/my_nihon_app:latest'
                    sh 'docker login -u "$USERNAME" -p "$PASSWORD"'
                    sh 'docker push "$USERNAME"/my_nihon_app:latest'
                    sh 'docker logout'
                }
}
