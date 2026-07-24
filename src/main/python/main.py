from typing import Dict, Any

from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()


@app.post("/receive")
async def receive_data(payload: Dict[str, Any]):
  print(f"Data {payload}")
  return {"status": "success"}


if __name__ == '__main__':
  import uvicorn
  uvicorn.run(app, host="127.0.0.1", port=8000)
