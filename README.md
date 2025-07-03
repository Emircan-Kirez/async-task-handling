# ThreadPoolExecutor Task Submission Flow

When a task is submitted:

1. If the number of running threads is less than `corePoolSize`, a new thread is created.
2. If `corePoolSize` threads are busy, the task is added to the **queue**.
3. If the **queue** is full, new threads are created up to `maxPoolSize`.
4. If `maxPoolSize` is reached **and** the queue is full, the task is **rejected**.

---

### 💡 Key Insight

`queueCapacity` controls how quickly the thread pool scales up to `maxPoolSize`.

- A **large queueCapacity** delays the need to create new threads.
- A **small queueCapacity** causes the pool to reach `maxPoolSize` more quickly.
