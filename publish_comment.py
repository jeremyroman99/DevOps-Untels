import json
import os
from github import Github

# Obtener el token de GitHub
github_token = os.environ['GITHUB_TOKEN']

# Crear una instancia de la clase Github
g = Github(github_token)

# Obtener el número del pull request desde el archivo de evento
with open(os.environ['GITHUB_EVENT_PATH'], 'r') as f:
    event_data = json.load(f)
    pr_number = event_data['pull_request']['number']

# Obtener el contexto del repositorio
repository = os.environ['GITHUB_REPOSITORY']
repo = g.get_repo(repository)

# Leer el contenido del archivo
with open('formatted_overview.txt', 'r') as file:
    content = file.read()

# Crear el cuerpo del comentario
comment_body = f"Datos de revisión formateados:\n```\n{content}\n```"

# Publicar el comentario en el pull request
pr = repo.get_pull(int(pr_number))
pr.create_issue_comment(comment_body)

