# Smooth Boot - 1.14 Fabric
Improve Minecraft threaded performance.

## Features

- Change # of threads used by Minecraft executors.
- Change the thread priority of each thread.
- Everything is configurable in the mod config.

## Effects

- Loading speed is improved.
- Loading is much smoother, and do not slow down other programs that are running at the same time.\

## Configuration

The config is split into two groups: *thread count* and *thread priority*.

Note: the config is slightly different for every Minecraft version, so please read the correct README for your version.

### Thread count

- Thread count is the # of threads used for each executor.
- This modifies `parallelism` in `ForkJoinPool`.
- If Minecraft is using too much CPU, you can lower these values.
- Conversely, if there's still headroom with the CPU usage, especially if you have a high core count CPU, you can increase these values which will improve performance.

### Thread priority

- Thread priority is the priority given to each thread.
- This calls `Thread.setPriority()` for each thread.
- This is similar to changing an application's priority in the task manager.
- The effect may be hardware/OS dependant.
- If Minecraft is still causing other programs to slow down, you can lower these values.
- If you want to dedicate more performance to Minecraft, you can increase these values.

### Optimizations

- These are optimizations that can improve performance
- DataFixers: Make `DataFixerBuilder.build()` run on a single thread as it doesn't scale well with multithreading