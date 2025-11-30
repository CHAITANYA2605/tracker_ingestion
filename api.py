import json

payload = {
    "userid": "usr_8f4e1a2b",
    "deviceid": "dev_01",
    "deviceinfo": {"platform": "iOS", "os_version": "18.1"},
    "events": []
}

for i in range(0, 1001):
    payload["events"].append({
        "name": f"event_{i}",
        "properties": {"index": i}
    })

with open("payload.json", "w") as f:
    json.dump(payload, f)
