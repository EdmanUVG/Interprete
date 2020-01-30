
import datetime



# reg[0] = arramemm[25] = hora =b
# reg[1] = arraymem[26] = min = c
#
# sum reg[2] = reg[0] + reg[1]
# reg[2] = arramemor[27]
#
# D = 2 * B
# MUL reg[3] = 2 + reg[0]
# reg[3] = arramemor[28]


# ops 25
# pos 26 = min  = c

# 32 bits = 2^32 * 32 = xxxx / 32 = xxx x bits / byte = xxx bytes



def interpret(memory, starting_address):

    PC = 0
    AC = 0
    instr = 0
    instr_type = 0
    data_loc = 0
    data = 0
    run_bit = True

    now = datetime.datetime.now()

    arrayMemory = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    registro = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

    arrayMemory[25] = hour = now.hour
    arrayMemory[26] = minuto = now.minute

    registro[0] = arrayMemory[25]  # = a
    registro[1] = arrayMemory[26]  # = b
    registro[2] = registro[0] + registro[1]
    # memory[27] = registro[2]

    print("A: " , arrayMemory[25])
    print("B: ", arrayMemory[26])

    registro[0] = arrayMemory[25]
    registro[1] = arrayMemory[26]

    PC = starting_address

    while (run_bit):
        instr = 0
        PC = PC + 1
        print("Ciclo: ", PC)
        instr_type = get_instr_type(instr)
        data_loc = find_data(instr, instr_type)
        if (data_loc >= 00):
            data = memory
            run_bit = False
            execute(instr_type, data)


def get_instr_type(instr):
    instructions_type = [0, 1,  2,  3]
    return instructions_type[instr]


def find_data(instr, type):
    location = 134
    return location


def execute(type, data):
    if (type == "ADD"):
        data + data
    if (type == "SUM"):
        data - data
    if (type == "MUL"):
        data * data
    if (type == "DIV"):
        data / data


interpret(2, 4)

