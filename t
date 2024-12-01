[0;1;32m●[0m ollama.service - Ollama Service
     Loaded: loaded (/etc/systemd/system/ollama.service; enabled; vendor preset: enabled)
     Active: [0;1;32mactive (running)[0m since Sun 2024-12-01 14:51:06 EST; 48s ago
   Main PID: 37348 (ollama)
      Tasks: 21 (limit: 38255)
     Memory: 500.1M
        CPU: 4.548s
     CGroup: /system.slice/ollama.service
             └─37348 /usr/local/bin/ollama serve

Dec 01 14:51:06 pop-os ollama[37348]: 2024/12/01 14:51:06 routes.go:1197: INFO server config env="map[CUDA_VISIBLE_DEVICES: GPU_DEVICE_ORDINAL: HIP_VISIBLE_DEVICES: HSA_OVERRIDE_GFX_VERSION: HTTPS_PROXY: HTTP_PROXY: NO_PROXY: OLLAMA_DEBUG:false OLLAMA_FLASH_ATTENTION:false OLLAMA_GPU_OVERHEAD:0 OLLAMA_HOST:http://127.0.0.1:11434 OLLAMA_INTEL_GPU:false OLLAMA_KEEP_ALIVE:5m0s OLLAMA_LLM_LIBRARY: OLLAMA_LOAD_TIMEOUT:5m0s OLLAMA_MAX_LOADED_MODELS:0 OLLAMA_MAX_QUEUE:512 OLLAMA_MODELS:/usr/share/ollama/.ollama/models OLLAMA_MULTIUSER_CACHE:false OLLAMA_NOHISTORY:false OLLAMA_NOPRUNE:false OLLAMA_NUM_PARALLEL:0 OLLAMA_ORIGINS:[http://localhost https://localhost http://localhost:* https://localhost:* http://127.0.0.1 https://127.0.0.1 http://127.0.0.1:* https://127.0.0.1:* http://0.0.0.0 https://0.0.0.0 http://0.0.0.0:* https://0.0.0.0:* app://* file://* tauri://* vscode-webview://*] OLLAMA_SCHED_SPREAD:false OLLAMA_TMPDIR: ROCR_VISIBLE_DEVICES: http_proxy: https_proxy: no_proxy:]"
Dec 01 14:51:06 pop-os ollama[37348]: time=2024-12-01T14:51:06.574-05:00 level=INFO source=images.go:753 msg="total blobs: 0"
Dec 01 14:51:06 pop-os ollama[37348]: time=2024-12-01T14:51:06.574-05:00 level=INFO source=images.go:760 msg="total unused blobs removed: 0"
Dec 01 14:51:06 pop-os ollama[37348]: time=2024-12-01T14:51:06.574-05:00 level=INFO source=routes.go:1248 msg="Listening on 127.0.0.1:11434 (version 0.4.6)"
Dec 01 14:51:06 pop-os ollama[37348]: time=2024-12-01T14:51:06.575-05:00 level=INFO source=common.go:135 msg="extracting embedded files" dir=/tmp/ollama3743880504/runners
Dec 01 14:51:06 pop-os ollama[37348]: time=2024-12-01T14:51:06.686-05:00 level=INFO source=common.go:49 msg="Dynamic LLM libraries" runners="[cpu cpu_avx cpu_avx2 cuda_v11 cuda_v12 rocm]"
Dec 01 14:51:06 pop-os ollama[37348]: time=2024-12-01T14:51:06.686-05:00 level=INFO source=gpu.go:221 msg="looking for compatible GPUs"
Dec 01 14:51:06 pop-os ollama[37348]: time=2024-12-01T14:51:06.930-05:00 level=INFO source=types.go:123 msg="inference compute" id=GPU-8e7efe50-5dcd-6847-656a-540d8995eb22 library=cuda variant=v12 compute=8.6 driver=12.6 name="NVIDIA GeForce RTX 3060 Laptop GPU" total="5.7 GiB" available="5.4 GiB"
Dec 01 14:51:23 pop-os ollama[37348]: time=2024-12-01T14:51:23.737-05:00 level=INFO source=download.go:175 msg="downloading 04778965089b in 16 100 MB part(s)"
Dec 01 14:51:53 pop-os ollama[37348]: time=2024-12-01T14:51:53.798-05:00 level=INFO source=download.go:370 msg="04778965089b part 9 stalled; retrying. If this persists, press ctrl-c to exit, then 'ollama pull' to find a faster connection."
