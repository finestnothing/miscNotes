# LPIC-1 Training Notes

[Jump back to list of notes](../README.md)

[Link to training](https://learning.lpi.org/en/learning-materials/101-500/)

- [LPIC-1 Training Notes](#lpic-1-training-notes)
  - [101.1-Determine and Configure Hardware Settings](#1011-determine-and-configure-hardware-settings)
    - [Device Inspection](#device-inspection)
    - [Commands for Inspection](#commands-for-inspection)
  - [101.2-System Boot](#1012-system-boot)
    - [Grub Commands](#grub-commands)
  - [101.3-Change runlevels, boot targets, shutdown or reboot system](#1013-change-runlevels-boot-targets-shutdown-or-reboot-system)

## 101.1-Determine and Configure Hardware Settings

### Device Inspection

Check in UEFI/BIOS if something is not working correctly. If the hardware is not detected there, then the problem is almost certainly in the hardware or the port itself.
Otherwise, the issue is probably with the operating system.

### Commands for Inspection

`lspci` - Show all devices connected to the PCI bus (motherboard). Could be disk controller or expansion card (external gpu)

`lsusb` - Show all devices connected to the machine VIA USB port

Can use `-s` to show less information

Can use `-d [id]` to display detailed info about one device

## 101.2-System Boot

To access GRUB - Press `shift` while booting from BIOS, `esc` when booting from UEFI

### Grub Commands

- `acpi`: Enables/ disables ACPI support. `acpi=off` to disable support for acpi
- `init`: Sets an alternative initiator for the system. `init=/bin/bash` sets bash to the initiator so a shell session will start before OS
- `systemd.unit`: Sets systemd target to be activated. `systemd.unit=graphical.target`. To activate runlevel 1, just need `systemd.unit 1` or `systemd.unit S`
- `mem`: Sets amount of available ram. `mem=512M` limits ram to 512 MB
- `maxcpus`: limits number of cores visible. Value of 0 for non-multicore. `maxcpus=2` limites the number of processors to 2
- `quiet`: hides most boot messages
- `root`: Sets root partiton. `root=/dev/sda3`
- `ro`: makes initial mount of the root filesystem be read-only
- `rw`: allows writing in the initial boot of root filesystem

## 101.3-Change runlevels, boot targets, shutdown or reboot system

There needs to be a program to control the other programs. Historically, it was called SysVInit or Sys V. In modern distributions of linux, it is now a program called Systemd or Upstart.
SysVinit is the standard now. The standard provides states, or runlevels, and their corresponding service scripts needed to run them. They range from 0 to 6 with the following common purposes:

0. System shutdown
1. Single user mode, no network or non-essential capabilities (maintenance mode)
2. Not used often. If it is, implemented like 3.
3. Multi-user mode. Can log in by console or network
4. Not used often. If it is, implemented like 3.
5. Equivalent to 3 but with a GUI login
6. System restart

The program that manages the run levels is `/sbin/init`. When the system is initialized, the `init` program identifies the requested run level (normally 5) from the kernal of `/etc/inittab`.
