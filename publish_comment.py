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

# Leer el contenido del archivo formatted_overview.txt
with open('formatted_overview.txt', 'r') as file:
    lines = file.readlines()

# Almacenar cada línea en una variable individual
first_line = lines[0].strip()
second_line = lines[1].strip()

# Construir el cuerpo del comentario con las variables de las líneas
comment_body = f"{first_line}\n{second_line}"

# Publicar el contenido del archivo como un comentario en el pull request
pr = repo.get_pull(int(pr_number))
pr.create_issue_comment(comment_body)