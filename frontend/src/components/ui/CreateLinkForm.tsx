
import { z } from "zod"

import { P } from "@/components/ui/Typography"
import { zodResolver } from "@hookform/resolvers/zod"
import { useForm } from "react-hook-form"

import { Button } from "@/components/ui/button"
import {
    Form,
    FormControl,
    FormDescription,
    FormField,
    FormItem,
    FormLabel,
    FormMessage,
} from "@/components/ui/form"
import { Input } from "@/components/ui/input"

import { createLink } from "@/api/linkService"
import { redirect } from "react-router"

const formSchema = z.object({
    originalLink: z.string().url("Please enter a valid URL"),
})


export default function CreateLinkForm() {
    // form definition
    const form = useForm<z.infer<typeof formSchema>>({
        resolver: zodResolver(formSchema),
        defaultValues: {
            originalLink: "",
        },
    })

    // submit handler (type safe and validated)
    function onSubmit(values: z.infer<typeof formSchema>) {
        try {
            console.log(values)
            const data = createLink(values.originalLink);
            redirect("/track");

        } catch (error) {
            console.log("Error creating link", error);
        }

    }

    return (
        <>
            <Form {...form}>
                <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-4">
                    <FormField
                        control={form.control}
                        name="originalLink"
                        render={({ field }) => (
                            <FormItem>
                                <FormLabel>Redirect URL</FormLabel>
                                <FormControl>
                                    <Input placeholder="Ex. https://snareclick.com" {...field} />
                                </FormControl>
                                <FormDescription>
                                    <P>This is the destination your link will redirect to.</P>
                                </FormDescription>
                                <FormMessage />
                            </FormItem>
                        )}
                    />
                    <Button variant="outline" type="submit">Create Link</Button>
                </form>
            </Form>
        </>
    )
}