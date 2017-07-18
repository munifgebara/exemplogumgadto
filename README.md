# exemplogumgadto
exemplogumgadto

JHipster like:

POST: http://localhost:8084/exemplo-api/api/pessoa
{ "nome": "Claudia", "pai": 3}

GET: http://localhost:8084/exemplo-api/api/pessoa
{
    "pageSize": 10,    "count": 4,    "start": 0,
    "values": [
        {
            "id": 1,
            "nome": "Munif",
            "pai": 3
        },
        {
            "id": 2,
            "nome": "Vicente",
            "pai": 1
        },
        {
            "id": 3,
            "nome": "Munifather",
            "pai": null
        },
        {
            "id": 5,
            "nome": "Claudia",
            "pai": 3
        }
    ]
}

