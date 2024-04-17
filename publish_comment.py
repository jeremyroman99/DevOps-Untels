from github import Github
import os

# Obtener el token de GitHub
github_token = os.environ['GITHUB_TOKEN']

# Crear una instancia de la clase Github
g = Github(github_token)

# Obtener el contexto del repositorio y el número del pull request
repo = g.get_repo(os.environ['GITHUB_REPOSITORY'])
pr_number = os.environ['GITHUB_EVENT_NUMBER']

# Leer el contenido del archivo
with open('formatted_overview.txt', 'r') as file:
    content = file.read()

# Crear el cuerpo del comentario
comment_body = f"Datos de revisión formateados:\n```\n{content}\n```"

# Publicar el comentario en el pull request
pr = repo.get_pull(int(pr_number))
pr.create_issue_comment(comment_body)
