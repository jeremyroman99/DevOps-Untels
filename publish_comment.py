import json
import os
from github import Github
import tabulate

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

# Leer el número de errores y advertencias del lint
lint_errors = os.environ.get('LINT_ERRORS', 'N/A')
lint_warnings = os.environ.get('LINT_WARNINGS', 'N/A')

# Convertir la tabla Markdown en una cadena de texto legible
# Aquí asumo que el contenido de la tabla es válido y tiene tres columnas
lines = content.strip().split('\n')[1:]  # Ignorar la primera línea (cabecera)
table_data = [line.split('|')[1:-1] for line in lines]  # Extraer datos de la tabla
formatted_table = tabulate.tabulate(table_data, headers=['Command', 'Description'], tablefmt='pipe')

# Crear el cuerpo del comentario con el número de errores y advertencias
comment_body = f"```\n{table_content}\n```"

# Publicar el comentario en el pull request
pr = repo.get_pull(int(pr_number))
pr.create_issue_comment(comment_body)
