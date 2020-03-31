#!/usr/bin/env groovy Jenkinsfile
pipeline {
    agent any
    
    stages {
       
        stage('下载代码') { 
            steps {
                echo '******************************开始下载源码******************************'
                git branch: 'master', url: 'https://gitee.com/guxiaotu/Jenkinsfile-test.git'
            }
        }

        stage('编译代码') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }

            steps {
                echo '******************************开始编译源码******************************'
                sh 'mvn clean package -Dmaven.test.skip=true'   
            }
        }

        stage('构建Docker镜像') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }

            steps {
/*                 
                echo '******************************删除旧容器******************************'
                sh 'docker rm -f springboottest'
*/             
                echo '******************************开始构建镜像******************************'
                sh 'mvn install dockerfile:build'
            }
        }
/*
        stage('推送IMAGE到Docker仓库') {
             steps {
                echo '***************************PUSH镜像到Doker hub**************************'
                sh 'docker push guxiaotu/springboottest:1.5.13'
            }
        }                
*/
        stage('创建容器') {
            steps {
                echo '*****************************创建容器*****************************'
                sh 'docker run -d --name=springboottest -p 8888:8888 guxiaotu/springboottest:1.5.13'
            }
        } 

    }
         
}