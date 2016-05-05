#include <MsgBoxConstants.au3>

If(WinActive("File Upload", "")) Then
ControlFocus("File Upload", "", "Edit1")
ControlSetText("File Upload", "", "Edit1","C:\Users\EdgarR\Pictures\grmpcat.jpg")
ControlClick("File Upload", "", "Button1")
ElseIf(WinActive("Open", "")) Then
	ControlFocus("Open", "", "Edit1")
	ControlSetText("Open", "", "Edit1","C:\Users\EdgarR\Pictures\grmpcat.jpg")
	ControlClick("Open", "", "Button1")
ElseIf(WinActive("Choose File to Upload", "")) Then
	ControlFocus("Choose File to Upload", "", "Edit1")
	ControlSetText("Choose File to Upload", "", "Edit1", "C:\Users\EdgarR\Pictures\grmpcat.jpg")
	ControlClick("Choose File to Upload", "", "Button1")
Else
	MsgBox($MB_OK, "Alerta", "No seencuentra ventana de windows")
EndIf




