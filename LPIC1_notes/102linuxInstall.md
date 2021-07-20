# LPIC-1 Training Notes

[Jump back to list of notes](../README.md)

[Link to training](https://learning.lpi.org/en/learning-materials/101-500/102/102.1/102.1_01/)

- [LPIC-1 Training Notes](#lpic-1-training-notes)
  - [102.1-Design had disk layout](#1021-design-had-disk-layout)
    - [Mount points](#mount-points)
    - [Keeping Things Separated](#keeping-things-separated)
    - [Boot partiton](#boot-partiton)
    - [EFI System Partition (ESP)](#efi-system-partition-esp)
    - [Swap](#swap)

## 102.1-Design had disk layout

### Mount points

Mounting means to connect a filesystem to a specific point in a systems directory tree, referred to as a `mount point`.
Once mounted, the contents are available under the mountpoint. For example, if we have users `jack` and `john` mounted to the `home` mount point, the contents would be accessible in`/home/jack/` and `/home/john` respectively.
You can only mount to an existing mount point. For example, you can't use `/mnt` as a mount point if mnt has not been made yet. If a filesystem is mounted to an existing directory, the contents of the directory are unavailable until the other filesystem is unmounted. 
Initially, the default mount point was `/mnt`, such as `/mnt/floppy`, etc. In modern systems, the default mount point is `/media`. USBs and other storage media are automatically mounted into the `/media` mount point. This being said, it is best practice to manually mount filesystems under `/mnt` and leave the `/media` mount point for automatic mountings.

### Keeping Things Separated

There are some things you should keep separate. It is best to keep bootloader-files on a boot partition incase the `/home` partition crashes and is unable to boot.  
It is best to keep home users data under `/home` so it is easy to fix the file system without disturbing the user data.  
It is also a good idea to split directories up in some ways. The root `/` folder should be kept on an ssd if possible, while the large directories like `/home` and `/var` can be put on a lager but slower hdd.

### Boot partiton

`/boot` Directory normally has the files needed for booting under `/boot/grub` and are used for starting the system. Technically,this partition is not needed since grub can mount to `/` and load files from the `/boot` directory, but it is best to isolate the basic boot files.

### EFI System Partition (ESP)

Name comes from the `Unified Extensible Firmware Interface` (UEFI) and stores boot leaders and kernals.
Is a FAT-based filesystem. Under GUID, it has a unique identifier of `C12A7328-F81F-11D2-BA4B-00A0C93EC93B`. Under MBR,the partition ID is `0xEF`.

### Swap

Uses to swap memory pages from the disk to RAM, and vice-versa. The partition needs to be a specific kind, and set up with `mkswap` before it can be used.
It cannot be mounted and viewed like a normal directory.
