package year_2015.day_23

class Turing {

    List<Instruction> instructions

    Turing(List<String> instructions) {
        this.instructions = instructions.collect { new Instruction(it)}
    }

    int getB(){
        execute()
    }

    int getNewB() {
        execute(1)
    }

    private execute(int a = 0, int b = 0) {
        for (int i = 0; i < instructions.size(); i++) {
            Instruction inst = instructions[i]

            switch (inst.type) {
                case InstructionType.HLF:
                    if (inst.register == 'a') {
                        a/=2
                    } else {
                        b/=2
                    }
                    break
                case InstructionType.TPL:
                    if (inst.register == 'a') {
                        a*=3
                    } else {
                        b*=3
                    }
                    break
                case InstructionType.INC:
                    if (inst.register == 'a') {
                        a++
                    } else {
                        b++
                    }
                    break
                case InstructionType.JMP:
                    i+= inst.offset - 1
                    break
                case InstructionType.JIE:
                    if (inst.register == 'a' ? a % 2 == 0 : b % 2 == 0) {
                        i+= inst.offset - 1
                    }
                    break
                case InstructionType.JIO:
                    if (inst.register == 'a' ? a == 1 : b == 1) {
                        i+= inst.offset - 1
                    }
                    break
                default:
                    throw new IllegalArgumentException()
            }
        }

        b
    }

    private class Instruction {

        private InstructionType type
        private String register
        private int offset

        private Instruction(String line) {
            type = getType(line.split()[0])

            switch (type) {
                case InstructionType.JMP:
                    offset = line.split()[1] as int
                    break
                case InstructionType.JIE:
                case InstructionType.JIO:
                    offset = line.split()[2] as int
                    register = line.split()[1].replace(',', '')
                    break
                default:
                    register = line.split()[1]
                    break
            }
        }
    }

    private static InstructionType getType(String type) {
        switch (type) {
            case 'hlf':
                return InstructionType.HLF
            case 'tpl':
                return InstructionType.TPL
            case 'inc':
                return InstructionType.INC
            case 'jmp':
                return InstructionType.JMP
            case 'jie':
                return InstructionType.JIE
            case 'jio':
                return InstructionType.JIO
            default:
                throw new IllegalArgumentException()
        }
    }

    private enum InstructionType {
        HLF, TPL, INC, JMP, JIE, JIO
    }
}
