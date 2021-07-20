# LPIC-1 Training Notes

[Jump back to list of notes](../README.md)

- [LPIC-1 Training Notes](#lpic-1-training-notes)
  - [102.1-Design had disk layout](#1021-design-had-disk-layout)
    - [Mount points](#mount-points)
    - [Keeping Things separated](#keeping-things-separated)

## 102.1-Design had disk layout

### Mount points

Mounting means to connect a filesystem to a specific point in a systems directory tree, referred to as a `mount point`.
Once mounted, the contents are available under the mountpoint. For example, if we have users `jack` and `john` mounted to the `home` mount point, the contents would be accessible in`/home/jack/` and `/home/john` respectively. 
You can only mount to an existing mount point. For example, you can't use `/mnt` as a mount point if mnt has not been made yet. If a filesystem is mounted to an existing directory, the contents of the directory are unavailable until the other filesystem is unmounted. 
Initially, the default mount point was `/mnt`, such as `/mnt/floppy`, etc. In modern systems, the default mount point is `/media`. USBs and other storage media are automatically mounted into the `/media` mount point. This being said, it is best practice to manually mount filesystems under `/mnt` and leave the `/media` mount point for automatic mountings.

### Keeping Things separated
