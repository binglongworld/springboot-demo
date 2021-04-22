package com.hl.springbootdemo1.pattern.facade;

/**
 * 外观设计模式
 */
public class ComputerMaker {
    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public ComputerMaker() {

    }

    public ComputerMaker(CPU cpu, Memory memory, Disk disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    public void startComputer() {
        cpu.startCPU();
        memory.startMemory();
        disk.startDisk();
    }

    public void stopComputer() {
        disk.stopDisk();
        memory.stopMemory();
        cpu.stopCPU();
    }

    public class CPU {
        public void startCPU() {
            System.out.print("启动CPU！\n");
        }

        public void stopCPU() {
            System.out.print("关闭CPU！\n");
        }
    }

    public class Memory {
        public void startMemory() {
            System.out.print("启动内存！\n");
        }

        public void stopMemory() {
            System.out.print("清理内存！\n");
        }
    }

    public class Disk {
        public void startDisk() {
            System.out.print("启动硬盘！\n");
        }

        public void stopDisk() {
            System.out.print("关闭硬盘！\n");
        }
    }

    public static void main(String[] args) {
        CPU cpu = new ComputerMaker().new CPU();
        Memory memory = new ComputerMaker().new Memory();
        Disk disk = new ComputerMaker().new Disk();

        ComputerMaker maker = new ComputerMaker(
                cpu, memory, disk
        );
        System.out.print("开机\n");
        maker.startComputer();
        System.out.print("=============\n");
        System.out.print("关机\n");
        maker.stopComputer();
    }
}
