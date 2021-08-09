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
  - [102.2 Install a Boot Manager](#1022-install-a-boot-manager)
    - [GRUB Legacy vs GRUB 2](#grub-legacy-vs-grub-2)
    - [MBR Partitions](#mbr-partitions)
    - [The boot Partition](#the-boot-partition)
    - [Contents of the boot Partition](#contents-of-the-boot-partition)
    - [GRUB 2](#grub-2)
    - [Managing Menu Entries](#managing-menu-entries)
    - [Booting from GRUB 2 shell](#booting-from-grub-2-shell)
  - [102.3 Linux Installation and Package Management](#1023-linux-installation-and-package-management)
    - [Introduction](#introduction)
    - [Concept of shared Libraries](#concept-of-shared-libraries)
  - [Shared Object File Naming Conventions](#shared-object-file-naming-conventions)
    - [Configuration of Shared Library paths](#configuration-of-shared-library-paths)
    - [Searching for dependencies of a particualar executable](#searching-for-dependencies-of-a-particualar-executable)

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

## 102.2 Install a Boot Manager

### GRUB Legacy vs GRUB 2

GRUB2 is a rewrite of GRUB legacy for an all around improved idea. It also supports themes and graphical boot menus, boot LiveCD ISO's, support for x86 architecture.

### MBR Partitions

Historically used on IBM PC's starting in 1982. The first 512-byte sector of the disk is called the Master Boot Record, and contains a table describing the contents on the disk and the bootstrap code, called the bootloader.
When the computer is turned on, the bootloader/bootstrap code is loaded, executed, and passes control to a secondary boot loader on disk, usually on a 32KB space between the MBR andfirst partitiion, which then loads the operating system.
MBR has a restriction of 3 partitions (plus an additional one solely for storage).

### The boot Partition

On linux the files necessary for the boot process are usually stored on a boot partition, mounted under the root file system and colloquially referred to as `/boot`.

### Contents of the boot Partition

- Config file
  - This file is called something like `config-4.15.0-65-generic`.
  - Stores configuration parameters for the Linux kernal. It is automatically generated when a new kernal is compiled or installed and *should not* be directly modified by the user.
- System map
  - Serves as a look-up table matching symbol names to their position in memory.
  - Useful for debugging a system failure called a *kernal panic* as it would let you know what variable or function was being called when the failure occured.
  - Normally called something like `System.map-4.15.0-65-generic
- Linux kernal
  - This is the operating system kernal proper.
  - The name is usually `vmlinux-4.15.0-65-generic`. Could also be called vmlinuz if it has been compressed
- Initial RAM disk
  - Called initrd.img-VERSION and contains a minimal root file system loaded into RAM.
  - Contains utilities and kernal modules needed so the real filesystem can be loaded.
- Boot loader related files
  - On systems with GRUB installed,these are usually located on `/boot/grub`and include the GRUB configuration file (`/boot/grub/grub.cfg`) for GRUB 2 or `/boot/grub/menu.lst` in case of GRUB Legacy.
  - Modules go in `/boot/grub/i386-pc`
  - Translation files in `/boot/grub/locale`
  - fonts in `/boot/grub/fonts`

### GRUB 2

GRUB 2 can be installed using the `grub-install` utility. If there is a non-booting system, you will need to boot using a live CD or rescure disc, find out what the boot partition is for the system, mount it, then run the utility.
The first disk on a system is usually the boot device and you may need to know whether there is a boot partition on the disk. This can be done using the `fdisk` utility. To run this on the first disk, use the command `/fdisk -l /dev/sda`. The boot partition is marked with an asterisk.

Installing GRUB2

- `fdisk -l /dev/sda1` (select the partition that has an asterisk marking it as a boot partition)
- `mkdir /mnt/tmp`
- `mount /dev/sda1 /mnt/tmp`
- `grub-install --boot-directory=/mnt/tmp /dev/sda1`

Configuring GRUB2

The default configurationg for GRUB 2 is in `/boot/grub/grub.cfg`. It is automatically generating and manual editing is not recommended. To edit it, edit the file in `/etc/default/grub`, then run `update-grub`

GRUB options

- `GRUB_DEFAULT=`
  - Default menu entry to boot. It can be a numeric entry (0,1,...), name of a menu entry (debian, etc), or `saved` which is used with `GRUB_SAVEDEFAULT=`
- `GRUB_SAVEDEFAULT=`
  - If set to `true` and `GRUB_DEFAULT=` is set to `saved`, then the default boot option will always be the most recently selected option in the boot menu.
- `GRUB_TIMEOUT=`
  - The timeout, in seconds,before the default menu entry is selected. If set to 0, it will boot the default option without showing a menu. Selecting -1 will wait until a user selects an option instead of timing out
- `GRUB_CMDLINE_LINUX=`
  - Lists the command line options that will be added to entries of the linux kernal
- `GRUB_CMDLINE_LINUX_DEFAULT=`
  - By default, two menu entries are generated for each linux kernal, one with the default options and one with entry for recovery. With the recovery option you can add extra parameters that will be added only to the default entry
- `GRUB_ENABLE_CRYPTODISK=`
  - If set to `y`, commands like `grub-mkconfig`,`update-grub`, and `grub-install` will look for encrypted disks and add the commands needed to access themduring boot. This disables automatic booting (boot with a timeout) because a passphrase is needed to decrypt the disks before they can be accessed

### Managing Menu Entries

When `update-grub` is run, it scans for new kernals and operating systems on the machine to generate menu entries on the `/boot/grub/grub.cfg` file. Can also be manually added to the `/etc/grub.d` directory.
The files need to be execuatable, and are processed in numberical order. 05-debian is processed before 10_linux, etc etc. Custom entries are normally added to the `40_custom` file.

Syntax for a menu entry:

```bash
menuentry "Default OS" {
  set root=(hd0,1)
  linux /vmlinuz root=/dev/sda1 ro quiet splash
  initrd /initrd.img
}
```

The first line is always the same, with "Default OS" replaced by the name to put in the GRUB menu.

set root defines the disk and partition where the root file system for the OS is. Disks are labelled from 0, so hd0 is the first. Partitions are labelled starting at 1, so the 1 is to say the first partition. (hd0, 1) says the first partition on the first disk.

The linux line determines where to look for the kernal

initrd line indicates where the inital RAM disk is located. In the example above, it is located in `initrd.img`

### Booting from GRUB 2 shell

From grub, you can use the command `ls`. It will list the disks. An example output is `(proc)(hd0)(hd0,msdos1)`. This means there is only one disk (hd0) with one partition `(hd0,msdos1)`. We can then do `ls (hd0,msdos1)/` to list the contents of the root partition.
We need to find a kernal (normally vmlinuz) and a initrd (initrd.img). If they are not in root, `/boot` is a good place to look.

From there, we need to run the following commands:

1. `set root=(hd0,msdos1)/`
2. `linux /vmlinuz root=/dev/sda1`
3. `initrd /initrd.img`
4. `boot`

And the system should boot correctly. If not, see booting from Grub Rescue Shell.

Website also goes over GRUB Rescure Shell, Setting up GRUB legacy, and chainloading operating systems.

## 102.3 Linux Installation and Package Management

### Introduction

This lesson will go over shared libraries, also known as shared objects. These are pieces of compiled code that get used by multiple programs.

### Concept of shared Libraries

Static libraries: A static library is merged with the program at link time. A copy of the library code gets embedded into the program and becomes part of it. This makes it so the program has no dependencies on the library at runtime since all the requisite files are already in the attached library. This is an advantage, but comes at the cost of being a far heavier program

Shared(or dynamic) libraries: The linker takes care that the program references libraries, but does not copy any library code into the program. The shared library is then a dependency for the program, but the program is much lighter and you only need one copy of the library instead of a copy embedded in each program.

## Shared Object File Naming Conventions

Made up of three parts:

- Library name (normally prefixed with `lib`)
- `so` (stands for shared object)
- Version number of the Library

Example: `libpthread.so.0`

By contrast, static library names are suffixed with an a: `libpthread.a`

Common shared libraries in a linux system:

- `/lib`
- `/lib32`
- `/lib64`
- `/usr/lib`
- `/usr/local/lib`

### Configuration of Shared Library paths

References in dynamically linked programd are resolved by the dynamic linker (ld.so or ld-linux.so) when the program is run. The dynamic linker searches for libraries in a number of directories, specified in the *library path*. The library path is configured in the `/etc` directory, specifically the `/etc/ld.so.conf` or more commonly in files in the `/etc/ld.so.conf.d` directory. The ld.so.conf file often includes `include` statements for the other files. For example: `include /etc/ld.so.conf.d/*.conf` to include all files.

The `ldconfig` config command takes care of reading the config files, creating a set of symbolic links to help located the individual libraries, and updates the cache file `/etc/ld.so.cache`. Because of this, `ldconfig` has to be run every time config files are added or updated.

### Searching for dependencies of a particualar executable

Use the `ldd` command followed by the absolute path of the program. For example, `ldd /usr/bin/git` for the dependenvies for git.