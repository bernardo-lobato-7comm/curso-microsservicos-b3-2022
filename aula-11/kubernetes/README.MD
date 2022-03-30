
# Cluster
Comandos para criação de cluster
## Criando cluster
`kind create cluster --name new-cluster`

## Criando um cluster através de um arquivo de configuração
`kind create cluster --config kind-config.yml`
## Deletando um cluster
`kind delete cluster --name new-cluster`

# Kubectl
Versao do app de linha de comando
`kubectl version`

### CLuster
Informações gerais do cluster
`kubectl cluster-info`
Informações dos Nodes
`kubectl get nodes`
`kubectl get nodes --help`
### Pods
`kubectl get pods`
`kubectl describe pods`

### Deployments
`kubectl create deployment kubernetes-bootcamp --image=gcr.io/google-samples/kubernetes-bootcamp:v1`
`kubectl get deployments`
### Rodando em uma rede privada
`kubectl proxy - habilita um proxy para acessar o cluster`

# Pods
`kubectl get pods`
`kubectl describe pods`
## Acessar diretamente o pod
`curl http://localhost:8001/api/v1/namespaces/default/pods/$POD_NAME/`
### Comandos diretamente em um pod
`kubectl exec $POD_NAME -- env`
`kubectl logs $POD_NAME`
`kubectl label pods $POD_NAME version=v1`
`kubectl get pods -l version=v1`

# Services
`kubectl get services`
`kubectl expose deployment/kubernetes-bootcamp --type="NodePort" --port 8080`
`kubectl describe services/kubernetes-bootcamp`

`export NODE_PORT=$(kubectl get services/kubernetes-bootcamp -o go-template='{{(index .spec.ports 0).nodePort}}')`
`echo NODE_PORT=$NODE_PORT`
`curl $(minikube ip):$NODE_PORT`

# Múltiplas instancias
`kubectl scale deployments/kubernetes-bootcamp --replicas=4`
`kubectl get pods -o wide`
`kubectl describe services/kubernetes-bootcamp`
`kubectl scale deployments/kubernetes-bootcamp --replicas=2`

# Atualizando a aplicação
`kubectl set image deployments/kubernetes-bootcamp kubernetes-bootcamp=jocatalin/kubernetes-bootcamp:v2`
`kubectl rollout status deployments/kubernetes-bootcamp`
`kubectl describe pods`

# Rollback uma atualização
`kubectl set image deployments/kubernetes-bootcamp kubernetes-bootcamp=gcr.io/google-samples/kubernetes-bootcamp:v10`
`kubectl rollout undo deployments/kubernetes-bootcamp`
