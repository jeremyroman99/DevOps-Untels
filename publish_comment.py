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

# Leer el contenido del archivo JSON
with open('formatted_table.json', 'r') as file:
    table_data = json.load(file)

# Construir la tabla Markdown a partir de los datos del archivo JSON
table_content = "| First Header | Second Header |\n| ------------- | ------------- |\n"
for item in table_data:
    table_content += f"| {item['First Header']} | {item['Second Header']} |\n"

# Crear el cuerpo del comentario con el contenido de la tabla
comment_body = f"```
                {
                "type": "Topology",
                "transform": {
                    "scale": [0.0005000500050005, 0.00010001000100010001],
                    "translate": [100, 0]},
                "objects": {
                    "example": {
                    "type": "GeometryCollection",
                    "geometries": [
                        {
                        "type": "Point",
                        "properties": {"prop0": "value0"},
                        "coordinates": [4000, 5000]
                        },
                        {
                        "type": "LineString",
                        "properties": {"prop0": "value0", "prop1": 0},
                        "arcs": [0]
                        },
                        {
                        "type": "Polygon",
                        "properties": {"prop0": "value0",
                            "prop1": {"this": "that"}
                        },
                        "arcs": [[1]]
                        }
                    ]
                    }
                },
                "arcs": [[[4000, 0], [1999, 9999], [2000, -9999], [2000, 9999]],[[0, 0], [0, 9999], [2000, 0], [0, -9999], [-2000, 0]]]
                }```"

# Publicar el contenido del archivo como un comentario en el pull request
pr = repo.get_pull(int(pr_number))
pr.create_issue_comment(comment_body)
