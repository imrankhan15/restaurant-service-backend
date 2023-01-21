
import {addNewGuest} from "./Client";
import {LoadingOutlined} from "@ant-design/icons";

import {Drawer, Input, Col, Select, Form, Row, Button} from 'antd';
import {errorNotification, successNotification} from "./Notification";


const {Option} = Select;


const antIcon = <LoadingOutlined style={{ fontSize: 24 }} spin />;

function GuestDrawerForm({ showGuestDrawer, setShowGuestDrawer}) {

    const onCLose = () => setShowGuestDrawer(false);

    const onFinish = guest => {

        console.log(JSON.stringify(guest, null, 2))
        addNewGuest(guest)
            .then(() => {
                console.log("guest added")
                onCLose();
                successNotification(
                    "guest successfully added",
                    `guest was added to the system`
                )

            }).catch(err => {
            console.log(err);
            err.response.json().then(res => {
                console.log(res);
                errorNotification(
                    "There was an issue",
                    `${res.message} [${res.status}] [${res.error}]`,
                    "bottomLeft"
                )
            });
        }).finally(() => {

        })
    };


    const onFinishFailed = errorInfo => {
        alert(JSON.stringify(errorInfo, null, 2));
    };

    return <Drawer
        title="Create new guest"
        width={720}
        onClose={onCLose}
        visible={showGuestDrawer}
        bodyStyle={{paddingBottom: 80}}
        footer={
            <div
                style={{
                    textAlign: 'right',
                }}
            >
                <Button onClick={onCLose} style={{marginRight: 8}}>
                    Cancel
                </Button>
            </div>
        }
    >
        <Form layout="vertical"
              onFinishFailed={onFinishFailed}
              onFinish={onFinish}
              hideRequiredMark>

            <Row gutter={16}>
                <Col span={12}>
                    <Form.Item
                        name="firstName"
                        label="Name"
                        rules={[{required: true, message: 'Please enter first name'}]}
                    >
                        <Input placeholder="Please enter first name"/>
                    </Form.Item>
                </Col>
                <Col span={12}>
                    <Form.Item
                        name="lastName"
                        label="lastName"
                        rules={[{required: true, message: 'Please enter last name'}]}
                    >
                        <Input placeholder="Please enter last name"/>
                    </Form.Item>
                </Col>
                <Col span={12}>
                    <Form.Item
                        name="email"
                        label="Email"
                        rules={[{required: true, message: 'Please enter  email'}]}
                    >
                        <Input placeholder="Please enter  email"/>
                    </Form.Item>
                </Col>
            </Row>

            <Row>
                <Col span={12}>
                    <Form.Item >
                        <Button type="primary" htmlType="submit">
                            Submit
                        </Button>
                    </Form.Item>
                </Col>
            </Row>
        </Form>
    </Drawer>



}

export default GuestDrawerForm;