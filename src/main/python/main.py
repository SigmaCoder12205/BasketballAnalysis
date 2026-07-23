import requests
import json

url = "http://localhost:8080/api/data"
payload = {"message": "G'day Java"}

try:
  print("Sending")
  response = requests.post(url, json=payload, headers={"Content-Type": "application/json"})

  if response.status_code == 200:
    print("Worked!")
    print(f"Java response: {response.text}")
  else:
    print(f"Sever returned: {response.status_code}")
    print(f"Details {response.text}")
except requests.exceptions.ConnectionError:
    print("❌ Connection Failed! Is your Java application actively running on port 8080?")
