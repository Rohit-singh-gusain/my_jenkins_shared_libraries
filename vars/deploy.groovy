def call(){
  echo "========= creating container==============="
  sh 'docker stop my_container'
  sh 'docker rm my_container'
  sh 'docker run -d -p 80:80 --name my_container rohitsinghgusain30/my_nihon_app:latest '
  echo "=========== container created successfully==========="
}
