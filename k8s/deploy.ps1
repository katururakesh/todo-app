kubectl set image deployment/todo-app todo-app=rakesh212h1a0577/todo-app:latest -n todo-app
kubectl rollout status deployment/todo-app -n todo-app
