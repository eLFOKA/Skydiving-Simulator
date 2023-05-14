import PySimpleGUI as sg


def calculate_eq(y0, m, b):


def do_the_work(y0, m, b):



layout = [
    [sg.Text("Initial height:")],
    [sg.InputText(key='y0')],
    [sg.Text("Mass:")],
    [sg.InputText(key='m')],
    [sg.Text("Air resistance:")],
    [sg.InputText(key='b')],
    [sg.Button("OK")]
]

window = sg.Window(title="Skydiving Simulator", layout=layout)

while True:
    event, values = window.read()

    if event == "OK":
        print(event, values['y0'], values['m'], values['b'])
        do_the_work()

    if event == sg.WIN_CLOSED:
        break

window.close()